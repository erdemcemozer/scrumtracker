<template>
    <v-menu transition="slide-y-transition"
            left offset-y top>

        <template #activator="{ on }">
            <v-btn text rounded min-width="auto" v-on="on" class="px-2">

                <img :src="`https://flag.pk/flags/4x3/` + localeCode($i18n.locale) + `.svg`"
                     width="28" height="20" class="rounded" :alt="$i18n.locale"/>

                <client-only v-if="!miniVariant">
                    <span class="pl-1 text-reset" :class="{'mb-2': miniVariant}" v-text="$i18n.locale"/>
                </client-only>

            </v-btn>
        </template>

        <v-card :width="$vuetify.breakpoint.smAndDown ? 245 : ''">

            <template v-if="$vuetify.breakpoint.smAndDown">
                <v-subheader v-text="$t('languageChoice')"/>

                <v-divider/>
            </template>

            <v-list dense>
                <v-list-item v-for="locale in $i18n.locales" :key="locale.code"
                             @click="setLang(locale.code)"
                             :to="switchLocalePath(locale.code)">

                    <v-list-item-icon class="mr-3">
                        <img :src="`https://flag.pk/flags/4x3/` + locale.code2 + `.svg`"
                             width="24" height="16" class="mt-1" :alt="locale.iso"/>
                    </v-list-item-icon>

                    <v-list-item-content>
                        <v-list-item-title v-text="locale.name"/>
                    </v-list-item-content>

                </v-list-item>
            </v-list>

        </v-card>
    </v-menu>
</template>

<script>
export default {
    name: "Language",
    props:{
        miniVariant: {
            type: Boolean,
            default: false
        }
    },
    methods: {

        setLang(lang) {
            this.$i18n.locale = lang;
            this.$storage.setCookie('lang', lang);
            this.$axios.setHeader('content-language', lang);
            this.$axios.setHeader('accept-language', lang);
        },

        localeName(code) {
            return this.$i18n.locales.find(lang => lang.code === code)?.name
        },

        localeCode(code) {
            return this.$i18n.locales.find(lang => lang.code === code)?.code2
        }

    }
}
</script>
