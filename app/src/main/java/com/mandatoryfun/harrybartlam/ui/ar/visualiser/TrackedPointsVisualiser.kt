package com.mandatoryfun.harrybartlam.ui.ar.visualiser

import android.content.Context
import com.mandatoryfun.harrybartlam.ui.ar.google.rendering.PointCloudRenderer
import com.mandatoryfun.harrybartlam.ui.ar.rendering.ARCoreDataModel

class TrackedPointsVisualiser(private val context: Context) {
    private val pointCloudRenderer = PointCloudRenderer()

    fun init() {
        pointCloudRenderer.createOnGlThread(context)
    }

    fun drawTrackedPoints(model: ARCoreDataModel) {
        val pointCloud = model.frame.acquirePointCloud()
        pointCloudRenderer.update(pointCloud)
        pointCloudRenderer.draw(model.cameraViewMatrix, model.cameraProjectionMatrix)
        // Application is responsible for releasing the point cloud resources after using it.
        pointCloud.release()
    }
}
