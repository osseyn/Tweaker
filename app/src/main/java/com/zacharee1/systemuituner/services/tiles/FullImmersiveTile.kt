package com.zacharee1.systemuituner.services.tiles

import android.annotation.TargetApi
import android.os.Build
import com.zacharee1.systemuituner.util.ImmersiveManager

@TargetApi(Build.VERSION_CODES.N)
class FullImmersiveTile : BaseImmersiveTile() {
    override val type = ImmersiveManager.ImmersiveMode.FULL
}