package com.example.marsapipm

import android.content.Context

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marsapipm.Model.Local.MarsDatabase
import com.example.marsapipm.Model.Remote.MarsRealState
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class MarsDatabaseTest {

    private lateinit var db: MarsDatabase

    // ----------------------------------------------------
    // Antes de cada test se crea una base de datos en memoria
    // ----------------------------------------------------


    @Before
    fun createDb() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(
            context,
            MarsDatabase::class.java
        ).allowMainThreadQueries() // necesario para tests simples
            .build()
    }


    @After
    fun closeDb()
    {
        db.close()
    }


// ----------------------------------------------------
    // Test: insertar un terreno y verificar que se guardó
    // ----------------------------------------------------
           @Test
        fun insertTerrainTest() = runBlocking{

            val terrain = MarsRealState(

               id="1",
                price= 40000,
                type ="rent",
                img_Src = "url"

            )

     db.marsDao().inserTerrain(terrain)

    val resultList = db.marsDao().getAllTerrains().value

    assertEquals(1,resultList?.size)
}

}