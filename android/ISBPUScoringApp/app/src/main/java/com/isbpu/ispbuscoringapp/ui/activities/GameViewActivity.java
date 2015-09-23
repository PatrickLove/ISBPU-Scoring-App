package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.ispbu.scoring.Game;

public class GameViewActivity extends Activity implements GameViewFragment.SaveOptionsHandler {

    Dialog progressDialog;
    Dialog cancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view);
        setResult(RESULT_CANCELED);

        GameViewFragment fragment = new GameViewFragment();
        fragment.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();

        cancelDialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.cancel_game_title))
                .setMessage(getString(R.string.cancel_game_message))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setResult(RESULT_OK);
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();

        progressDialog = new ProgressDialog.Builder(this)
                .setTitle(getString(R.string.saving_title))
                .setMessage(getString(R.string.saving_game_message))
                .setCancelable(false)
                .create();
    }

    @Override
    public void onCancelGame(Game g) {
        cancelDialog.show();
    }

    @Override
    public void onSaveGame(Game g) {
        progressDialog.show();
        final Context c = this;
        final Game toSave = g;
        new Thread(new Runnable() {
            @Override
            public void run() {
                GameDBEntry entry = new GameDBEntry(toSave);
                entry.save(c);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setResult(RESULT_OK);
                        progressDialog.dismiss();
                        finish();
                    }
                });
            }
        }).start();
    }

    @Override
    public void onEditGame(Game g) {
        finish();
    }

}
