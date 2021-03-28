<template>
    <v-list rounded flat class="py-4">

        <v-tooltip right nudge-right="10">
            <template #activator="{ on, attrs }">
                <v-list-item :to="localePath('index', $i18n.locale)"
                             active-class="primary--text"
                             v-bind="attrs" v-on="miniVariantStatus ? on : false">

                    <v-list-item-icon class="my-3" :class="{'mr-4': !miniVariantStatus}">
                        <v-icon v-text="'mdi-home-outline'"/>
                    </v-list-item-icon>

                    <v-list-item-title v-text="'Home'"/>

                </v-list-item>
            </template>
            Home
        </v-tooltip>

        <template v-for="(section, s) in navSections">

            <v-tooltip right nudge-right="10"
                       :key="s" v-if="section.children.length === 0">
                <template #activator="{ on, attrs }">
                    <v-list-item :to="localePath(section.path, $i18n.locale)"
                                 active-class="primary--text"
                                 v-bind="attrs" v-on="miniVariantStatus ? on : false">

                        <v-list-item-icon class="my-3" :class="{'mr-4': !miniVariantStatus}">
                            <v-icon v-text="`mdi-${section.icon}`"/>
                        </v-list-item-icon>

                        <v-list-item-title v-text="section.name"/>

                    </v-list-item>
                </template>
                {{section.name}}
            </v-tooltip>

            <v-list-group v-else>

                <template #activator>
                    <v-list-item-icon class="my-3" :class="{'mr-4': !miniVariantStatus}">
                        <v-icon v-text="`mdi-${section.icon}`"/>
                    </v-list-item-icon>

                    <v-list-item-title v-text="section.name"/>
                </template>

                <v-list-item v-for="(menu, m) in section.children" :key="m"
                             :to="localePath(menu.path, $i18n.locale)"
                             class="ml-10">

                    <v-list-item-content>
                        <v-list-item-title v-text="menu.name"/>
                    </v-list-item-content>

                </v-list-item>

            </v-list-group>

        </template>


    </v-list>
</template>

<script>
export default {
    name: "NavMenu",
    props:{
        miniVariantStatus:{
            type: Boolean,
        }
    },
    computed: {
        navSections() {
            return this.$store.state.nav.sections
        }
    }
}
</script>

<style lang="scss">
.v-list-item{
    &.v-list-item--active{

        &.v-list-group__header{
            box-shadow: inset 5px 5px 14px 0 rgba(0, 0, 0, 0.08), inset -8px -8px 10px 0 rgba(255, 255, 255, 0.4);
        }

        &:not(.v-list-group__header){
            box-shadow: 5px 5px 14px 0 rgba(0, 0, 0, 0.08), -12px -12px 10px 0 rgba(255, 255, 255, 0.4);
        }
    }
}

</style>
