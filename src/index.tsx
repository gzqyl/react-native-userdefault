import {NativeModules} from 'react-native';

const { RNUserDefault } = NativeModules;

export type MLKitLangCode = "en" | "zh" | "ja" | "ko"

export const getMLKitLangCode = async (): Promise<string> => {
  return RNUserDefault.getMLkitLang("fakeVal")
}

export const setMLKitLangCode = async (langCode: string): Promise<void> => {
  RNUserDefault.setMLkitLang(langCode)
}

export const isLangSetted = async (): Promise<boolean> => {
  return RNUserDefault.isLangSetted("fakeVal")
}