package com.github.gzqyl.rnuserdefault
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


class RNUserDefault(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext){

    override fun getName() = "RNUserDefault"

    @ReactMethod fun getMLkitLang(fakeVal: String, promise: Promise) {


        val langCode = RNUserDataStore(reactContext).getMLkitLang()
        promise.resolve(langCode)

    }

    @ReactMethod fun setMLkitLang(langCode: String, promise: Promise) {

       RNUserDataStore(reactContext).setMLkitLang(langCode)
       promise.resolve("ok")

    }

    @ReactMethod fun isLangSetted(fakeVal: String, promise: Promise) {

        val langSetted = RNUserDataStore(reactContext).isLangSetted()
        promise.resolve(langSetted)

    }


}