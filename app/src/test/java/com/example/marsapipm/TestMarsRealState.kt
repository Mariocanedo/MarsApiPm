package com.example.marsapipm

import com.example.marsapipm.Model.Remote.MarsRealState
import org.jetbrains.annotations.TestOnly
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue


class TestMarsRealState {

    private lateinit var  marsTerrain : MarsRealState


    @Before
    fun setUp(){

        // Creamos la instancia para test
            marsTerrain = MarsRealState(
                id = "1",
                price = 50000,
                type = "rent",
                img_Src = "url"
            )

    }

    @After
    fun tearDown(){
        // No hay recursos que liberar en este caso

    }

    @Test
    fun testMarsRealStateConstructor(){
        // Verificamos que los valores sean correctos
        assertEquals("1",marsTerrain.id)
        assertEquals(50000,marsTerrain.price)
        assertEquals("rent",marsTerrain.type)
        assertEquals("url",marsTerrain.img_Src)

    }


    @Test
    fun TestMarsRealStateNotNull(){
        assertNotNull(marsTerrain)
    }



    @Test

    fun testMarsRealStatePricePositive(){
        assertTrue  (marsTerrain.price>0)
    }

    @Test
    fun testDifferenteMarsRealStateObjects(){

        val otherTerrain = MarsRealState(

            id = "2",
            price = 50000,
            type = "buy",
            img_Src = "other_url"

        )

        assertNotNull(marsTerrain.id,otherTerrain.id)
        assertNotEquals(marsTerrain.price, otherTerrain.price)
    }



}