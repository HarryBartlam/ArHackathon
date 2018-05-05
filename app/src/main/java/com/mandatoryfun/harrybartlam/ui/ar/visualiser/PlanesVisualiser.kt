package com.mandatoryfun.harrybartlam.ui.ar.visualiser

import android.content.Context
import com.google.ar.core.Plane
import com.mandatoryfun.harrybartlam.ui.ar.google.rendering.PlaneRenderer
import com.mandatoryfun.harrybartlam.ui.ar.rendering.ARCoreDataModel

class PlanesVisualiser(private val context: Context) {
    private val planeRenderer = PlaneRenderer()

    fun init() {
        planeRenderer.createOnGlThread(context, "models/trigrid.png")
    }

    fun drawPlanes(model: ARCoreDataModel) {
        planeRenderer.drawPlanes(
                model.session.getAllTrackables(Plane::class.java),
                model.camera.displayOrientedPose,
                model.cameraProjectionMatrix
        )
    }
}
