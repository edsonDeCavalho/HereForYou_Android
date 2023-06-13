package com.equality.herforyou.core.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lieux_sure")
class LieuxSur(
    @PrimaryKey @ColumnInfo(name = "id") var id :Long,
    @ColumnInfo(name = "nom_lieu_sur") var nom_lieu_sur:String,
    @ColumnInfo(name = "long") var long:Float,
    @ColumnInfo(name = "lat") var lat:Float) {

}