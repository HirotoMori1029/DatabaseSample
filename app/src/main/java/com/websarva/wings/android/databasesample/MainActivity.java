package com.websarva.wings.android.databasesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //選択されたカクテルの主キーIDを表すフィールド
    private int _cocktailId = -1;
    //選択されたカクテル名を表すフィールド
    private String _cocktailName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //カクテルリスト用ListView(LvCocktail)を取得
        ListView lvCocktail = findViewById(R.id.lvCocktail);
        //lvCocktailにリスナを登録
        lvCocktail.setOnItemClickListener(new ListItemClickListener());
    }

    //保存ボタンがタップされたときの処理メソッド
    public void onSaveButtonClick(View view) {
        //感想欄を取得
        EditText etNote = findViewById(R.id.etNote);
        //感想欄の入力値を消去
        etNote.setText("");
        //カクテル名を未選択に変更
        TextView tvCocktailName = findViewById(R.id.tvCocktailName);
        tvCocktailName.setText(getString(R.string.tv_name));
        //保存ボタンをタップできないように変更
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setEnabled(false);
    }

    //リストが処理されたときのメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行番号をフィールドの主キーIDに代入
            _cocktailId = position;
            //タップされた行のデータを取得。これがカクテル名となるので、フィールドに代入。
            _cocktailName = (String) parent.getItemAtPosition(position);
            //カクテル名を表示するTextViewに表示カクテルを設定。
            TextView tvCocktailName = findViewById(R.id.tvCocktailName);
            tvCocktailName.setText(_cocktailName);
            //保存ボタンをタップできるように設定。
            Button btnSave = findViewById(R.id.btnSave);
            btnSave.setEnabled(true);
        }
    }
}