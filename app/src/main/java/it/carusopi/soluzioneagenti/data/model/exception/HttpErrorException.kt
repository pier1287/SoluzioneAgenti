package it.carusopi.soluzioneagenti.data.model.exception

/**
 * Created by carusopi on 04/11/2017.
 */
open class HttpErrorException(message: String?,var code: Int? = null) : SoluzioneAgentiException(message)