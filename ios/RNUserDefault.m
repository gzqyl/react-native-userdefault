//
//  RNUserDefault.m
//  react_native_userdefault
//
//  Created by gzqyl on 2023/12/31.
//

#import <Foundation/Foundation.h>
#import "RNUserDefault.h"
#import <React/RCTLog.h>

@implementation RNUserDefault

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(getMLkitLang:(NSString *) fakeVal
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    NSString* langCode = [[[RNUserDefaultSwift alloc] init] getMLKitLangSwift];
    resolve(langCode);
  
}

RCT_EXPORT_METHOD(setMLkitLang:(NSString *) langCode
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    
    RNUserDefaultSwift* swiftObj = [[RNUserDefaultSwift alloc] init];
    [swiftObj setMLKitLangSwift:langCode];
    resolve(@"ok");
  
}

RCT_EXPORT_METHOD(isLangSetted:(NSString *) fakeVal
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    
    RNUserDefaultSwift* swiftObj = [[RNUserDefaultSwift alloc] init];
    BOOL res = [swiftObj isLangSetted];
    if (res) {
        resolve(@YES);
    }else{
        resolve(@NO);
    }
  
}

@end
