package com.example.marvelcharacters.list

import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.gradle.PaparazziPlugin
import com.example.marvelcharacters.userInterface.list.ListStep
import com.kevinnzou.compose.core.paginglist.widget.DefaultEmptyListContent
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.google.testing.junit.testparameterinjector.TestParameterInjector;

@RunWith(TestParameterInjector::class)
class ListStepSnapshotTest {
    private val listStep: ListStep = mockk()

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
    )

    @Test
    fun snapshot() {
        paparazzi.snapshot {
            listStep.ListContent(
            )
        }
    }

}