export const state = ()=> ({

    miniVariant: false,

})

export const mutations = {

    SET_MINI_VARIANT(state, status){
        state.miniVariant = status
    }

}
