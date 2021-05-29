import colors from 'vuetify/es5/util/colors'

import i18n from './plugins/i18n'

export default {
    head: {
        titleTemplate: '%s - scrumtracker',
        title: 'scrumtracker',
        meta: [
            {charset: 'utf-8'},
            {name: 'viewport', content: 'width=device-width, initial-scale=1'},
            {hid: 'description', name: 'description', content: ''}
        ],
        link: [
            {rel: 'icon', type: 'image/x-icon', href: '/favicon.ico'}
        ]
    },

    css: [],

    plugins: [],

    components: {
        dirs: [
            '@/components',
            '@/components/pages',
            {
                path: '@/components/app',
                prefix: 'app'
            }
        ]
    },

    buildModules: [
        '@nuxtjs/vuetify',
    ],

    modules: [
        '@nuxtjs/axios',
        '@nuxtjs/pwa',
        'nuxt-i18n',
        '@nuxtjs/universal-storage'
    ],

    axios: {},

    i18n,

    vuetify: {
        customVariables: ['~/assets/scss/variables.scss'],
        theme: {
            dark: false,
            options: {
                customProperties: true,
            },
            themes: {
                dark: {
                    light: '#ecf2f6',
                    primary: colors.blue.darken2,
                    accent: colors.grey.darken3,
                    secondary: colors.amber.darken3,
                    info: colors.teal.lighten1,
                    warning: colors.amber.base,
                    error: colors.deepOrange.accent4,
                    success: colors.green.accent3
                },
                light: {
                    light: '#ccd7de',
                },
            }
        }
    },

    build: {}
}
