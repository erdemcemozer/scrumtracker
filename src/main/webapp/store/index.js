export const state = ()=> ({

    navbarToggle: false,
    miniVariant: false,
    pageTitle: null,

})

export const mutations = {

    SET_NAVBAR_TOGGLE(state, status){
        state.navbarToggle = status
    },

    SET_MINI_VARIANT(state, status){
        state.miniVariant = status
    },

    SET_PAGE_TITLE(state, title){
        state.pageTitle = title
    }

}
