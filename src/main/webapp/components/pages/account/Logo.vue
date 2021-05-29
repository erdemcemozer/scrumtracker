<template>
    <div class="mt-6 mt-md-12">
        <transition name="slide">
            <v-img :src="src" :max-height="$vuetify.breakpoint.mdAndUp ? 90 : 60"/>
        </transition>
    </div>
</template>

<script>
export default {
    name: "Logo",
    data(){
        return {
            src: require('@/static/scrumtracker-logo-2.png')
        }
    }
}
</script>

<style lang="scss" scoped>

.slide-enter {
}
.slide-enter-active{
    animation: slide-in 3s ease-out forwards;
}
.slide-leave{

}
.slide-leave-active{

}

@keyframes slide-in {
    from{
        transform: translateY(40px);
    }
    to{
        transform: translateY(0px);
    }
}

</style>
