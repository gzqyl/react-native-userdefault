//
//  RNUserDefault.swift
//  react_native_userdefault
//
//  Created by gzqyl on 2023/12/31.
//

import Foundation

@objc(RNUserDefaultSwift)
public class RNUserDefaultSwift: NSObject {
    
    @objc
    public func getMLKitLangSwift() -> String{
        
        if let langCode = UserDefaults().string(forKey: "mlkit-local-lang"){
            return langCode
        }
        return "en"
    }
    
    @objc
    public func setMLKitLangSwift(_ langCode: String){
        UserDefaults().set(langCode, forKey: "mlkit-local-lang")
    }

    @objc
    public func isLangSetted() -> Bool{
        if let _ = UserDefaults().string(forKey: "mlkit-local-lang"){
            return true
        }
        return false
    }
   
}
