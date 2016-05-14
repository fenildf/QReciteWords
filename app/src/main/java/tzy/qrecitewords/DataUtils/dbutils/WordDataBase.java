package tzy.qrecitewords.dataUtils.dbutils;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

import tzy.qrecitewords.javabean.Library;
import tzy.qrecitewords.javabean.Library_Table;
import tzy.qrecitewords.javabean.Word;

/**
 * Created by tzy on 2016/4/8.
 */
@Database(name = WordDataBase.NAME,version = WordDataBase.VERSION,foreignKeysSupported = true)
public class WordDataBase {
    //数据库名称
    public static final String NAME = "AppDatabase";
    //数据库版本号
    public static final int VERSION = 7;

    @Migration(version = WordDataBase.VERSION,database = WordDataBase.class)
    public static  class Migration_Library extends AlterTableMigration<Library>{

        public Migration_Library(Class<Library> table) {
            super(table);
        }

        @Override
        public void onPreMigrate() {
            super.onPreMigrate();
            /**v = 4*/
            //addColumn(SQLiteType.INTEGER, Library_Table.isSelected.getNameAlias().getName());

            /**v = 6*/
            addColumn(SQLiteType.INTEGER, Library_Table.countFam.getNameAlias().name());
            addColumn(SQLiteType.INTEGER, Library_Table.countNoFam.getNameAlias().name());
            addColumn(SQLiteType.INTEGER, Library_Table.countNoKnown.getNameAlias().name());
            addColumn(SQLiteType.INTEGER, Library_Table.countNoRead.getNameAlias().name());
        }
    }

    @Migration(version = WordDataBase.VERSION,database = WordDataBase.class)
    public static  class Migration_Delete extends AlterTableMigration<Library>{

        public Migration_Delete(Class<Library> table) {
            super(table);
        }

        @Override
        public void onPreMigrate() {
            super.onPreMigrate();
            //6
        }
    }
}