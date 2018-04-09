package it.carusopi.soluzioneagenti.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by carusopi on 08/04/2018.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)