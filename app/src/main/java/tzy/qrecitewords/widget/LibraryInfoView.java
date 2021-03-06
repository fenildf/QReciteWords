package tzy.qrecitewords.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import tzy.qrecitewords.R;
import tzy.qrecitewords.javabean.Library;

/**
 * Created by tzy on 2016/4/11.
 */
public class LibraryInfoView extends LinearLayout {

    TextView txLibraryName;

    WordLableView wlableNoread;

    WordLableView wlableFam;

    WordLableView wlableNofam;

    WordLableView wlableNoknown;

    public LibraryInfoView(Context context) {
       this(context,null);
    }

    public LibraryInfoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LibraryInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.view_library_info_layout, this, true);

        txLibraryName = (TextView) findViewById(R.id.tx_libraryName);

        wlableNoread = (WordLableView) findViewById(R.id.wlable_noread);
        wlableNoread.setTag(Library.Familiarity.noRead);

        wlableFam = (WordLableView) findViewById(R.id.wlable_fam);
        wlableFam.setTag(Library.Familiarity.familary);

        wlableNofam = (WordLableView) findViewById(R.id.wlable_nofam);
        wlableNofam.setTag(Library.Familiarity.nofamilary);

        wlableNoknown = (WordLableView) findViewById(R.id.wlable_nokonwn);
        wlableNoknown.setTag(Library.Familiarity.noknown);
    }

    public void setTxLibraryName(String libraryName,int countofWord){
        String name = libraryName + "(" + countofWord + ")";
        txLibraryName.setText(name);
    }

    public void setWlableNoread(String s){
        wlableNoread.setLNumText(s);
    }

    public void setWlableFam(String s){
        wlableFam.setLNumText(s);
    }

    public void setWlableNofam(String s){
          wlableNofam.setLNumText(s);
    }

    public void setWlableNoknown(String s){
        wlableNoknown.setLNumText(s);
    }

    /**设置为空词本*/
    public void setTxLibraryNameNull(){
        txLibraryName.setText(getResources().getString(R.string.library_not_selected));
        wlableNoread.setLNumText("0");
        wlableFam.setLNumText("0");
        wlableNofam.setLNumText("0");
        wlableNoknown.setLNumText("0");
    }

    public void setLibraryInfo(Library info){
        setTxLibraryNameNull();//先清楚清除之前的状态
        setTxLibraryName(info.getIntrodu(),info.getCountOfTotal());
        setWlableFam(info.getCountFam()+ "");
        setWlableNofam(info.getCountNoFam()+ "");
        setWlableNoknown(info.getCountNoKnown()+ "");
        setWlableNoread(info.getCountNoRead() + "");
    }

    public void hideTitle(boolean hide){
        if(hide){
            txLibraryName.setVisibility(View.GONE);
        }else{
            txLibraryName.setVisibility(View.VISIBLE);
        }
    }

    public void setwlableNoreadListener(OnClickListener l){
        wlableNoread.setOnClickListener(l);
    }

    public void setwlableFamListener(OnClickListener l){
        wlableFam.setOnClickListener(l);
    }

    public void setwlableNofamListener(OnClickListener l){
        wlableNofam.setOnClickListener(l);
    }

    public void setwlableNoknownListener(OnClickListener l){
        wlableNoknown.setOnClickListener(l);
    }
}
