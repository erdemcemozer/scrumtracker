<template>
    <div  class="pa-4">

        <v-col cols="12" v-if="$vuetify.breakpoint.mdAndUp">
            <logo-component/>
        </v-col>


        <v-col cols="12" class="my-6 my-md-12">
            <p class="text-center">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Aut dolores, enim facilis ipsa itaque laborum magnam nam necessitatibus reprehenderit sapiente,
                sequi, voluptates! Autem dolores laborum modi, odit quae qui ullam.
            </p>
        </v-col>

<!--        <transition name="slide">
            <div>Hello World</div>
        </transition>-->

    </div>
</template>

<script>

import LogoComponent from "@/components/pages/account/Logo";

export default {
    name: "Presentation",
    components: {
        LogoComponent
    },
    data(){
        return {
        }
    }
}
</script>


