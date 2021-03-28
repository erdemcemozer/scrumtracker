import routes from "./routes"

const i18n = {
    defaultLocale: 'tr',
    locale: 'tr',
    locales: [
        {code: 'tr', code2: 'tr', iso: 'tr_TR', file: 'tr/tr_TR.js', name: 'Türkçe'},
        {code: 'en', code2: 'us', iso: 'en_US', file: 'en/en_US.js', name: 'English'},
    ],
    lazy: true,
    langDir: 'lang/',
    detectBrowserLanguage: false,
    intervalPlural: true,
    parsePage: false,
    pages: routes
}

export default i18n
