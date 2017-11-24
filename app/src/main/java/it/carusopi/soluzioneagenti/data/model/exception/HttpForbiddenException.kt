package it.carusopi.soluzioneagenti.data.model.exception

/**
 * Created by carusopi on 24/11/2017.
 */
class HttpForbiddenException(messageDetail: String?): HttpErrorException(messageDetail, 403)