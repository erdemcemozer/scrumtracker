export const state = ()=> ({

    navbarToggle: false,
    miniVariant: false,
    pageTitle: null,
    usefulLinks: null,
    announcements: null,
    sprint: null,
    meeting: null,
    issues: null,
    users: null

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
    },

    SET_USEFUL_LINKS(state, usefulLinks){
        state.usefulLinks = usefulLinks
    },

    SET_ANNOUNCEMENTS(state, announcements){
        state.announcements = announcements
    },

    SET_SPRINT(state, sprint){
        state.sprint = sprint
    },

    SET_MEETING (state, meeting){
        state.meeting = meeting
    },

    SET_ISSUE (state, issue){
        state.issues = issue
    },

    SET_USERS (state, user){
        state.users = user
    }

}

export const actions = {
    async POST_USEFUL_LINKS_ADD({commit, dispatch}, payload) {
        //console.log('payload', payload)
        await this.$axios.$post(`http://localhost:8080/usefulLinks/add`,
             {
                 linkName: payload.link,
                 linkDescription: payload.description,
        }
        ).then(()=>{
            dispatch('GET_USEFUL_LINKS')
        })
    },
    async GET_USEFUL_LINKS({commit}) {
        await this.$axios.get(`http://localhost:8080/usefulLinks/listAll`).then((response)=>{
            commit('SET_USEFUL_LINKS', response.data)
            // console.log('response', response)
            }
        )
    },

    async POST_ANNOUNCEMENTS_ADD({commit, dispatch}, payload) {
        //console.log('payload', payload)
        await this.$axios.$post(`http://localhost:8080/announcements/createAnnouncement`,
             {
                 announcementTitle: payload.announcementTitle,
                 announcementDescription: payload.announcementDescription,
                 releaseDate: new Date().toISOString().slice(0, 10).split("-").reverse().join("-")
        }
        ).then(()=>{
            dispatch('GET_ANNOUNCEMENTS')
        })
    },
    async GET_ANNOUNCEMENTS({commit}) {
        await this.$axios.get(`http://localhost:8080/announcements/getAnnouncements`).then((response)=>{
            commit('SET_ANNOUNCEMENTS', response.data)
            // console.log('response', response)
            }
        )
    },
    async POST_ANNOUNCEMENTS_UPDATE({commit, dispatch},form) {
        await this.$axios.post(`http://localhost:8080/announcements/updateAnnouncement`, form).then((response)=>{
            dispatch('GET_ANNOUNCEMENTS')
            }
        )
    },
    async POST_ANNOUNCEMENTS_DELETE({commit, dispatch},payload) {
        await this.$axios.post(`http://localhost:8080/announcements/deleteAnnouncement`,payload).then(()=>{
            dispatch('GET_ANNOUNCEMENTS')
            }
        )
    },
    async POST_SPRINT_ADD({commit}, payload) {
        //console.log('payload', payload)
        await this.$axios.$post(`http://localhost:8080/board/createSprint`,
            {
                sprintName: payload.title,
                sprintDesc: payload.description,
            }
        ).then((response)=>{
            commit('SET_SPRINT', response.data)
        })
    },

    //################################## MEETINGS ################################################
    async POST_MEETING_RESULTS_ADD({commit, dispatch}, payload) {
        console.log('ddd', payload)
        await this.$axios.$post(`http://localhost:8080/meetingResults/createMeeting`,
            {
                title: payload.title,
                description: payload.description,
                meetingDate: new Date().toISOString().slice(0, 10).split("-").reverse().join("-"),
                meetingType: payload.type
            }
        ).then((response)=>{
            dispatch('GET_MEETING_RESULTS')
        })
    },
    async POST_MEETING_RESULTS_UPDATE({commit, dispatch}, payload) {
        await this.$axios.post(`http://localhost:8080/meetingResults/updateMeeting`,
            {
                title: payload.title,
                description: payload.description,
                meetingDate: payload.meetingDate,
                meetingType: payload.meetingType,
                meetingId: payload.meetingId
            }
        ).then(()=>{
            dispatch('GET_MEETING_RESULTS')
        })
    },
    async POST_MEETING_RESULTS_DELETE({commit,dispatch}, payload) {
        await this.$axios.$post(`http://localhost:8080/meetingResults/deleteMeeting`,payload).then(()=>{
            dispatch('GET_MEETING_RESULTS')
        })
    },
    async GET_MEETING_RESULTS({commit}) {
        await this.$axios.get(`http://localhost:8080/meetingResults/getMeetingResults`)
            .then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },

    //################################## USER UPDATE ################################################
    async POST_PROFILE_LOGIN({commit}, payload) {
        let email=this.$storage.getCookie('email')
        console.log("email",email)
        await this.$axios.get(`http://localhost:8080/users/getUser`, email).then((response)=>{
            console.log("response login",response)
            //commit('SET_MEETING', response.data)
        })
    },
    async GET_PROFILE_INFOS({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/users/updateUser`,
            {
                name: payload.name,
                surname: payload.surname,
                password: payload.password,
                phone: payload.phone,
                email: payload.email,
                team: 'Test'
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async POST_USER_DELETE({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/users/deleteUser`,
            {
                name: payload.name,
                surname: payload.surname,
                password: payload.password,
                phone: payload.phone,
                email: payload.email,
                team: payload.team
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async GET_USERS ({commit}, payload) {
        await this.$axios.get(`http://localhost:8080/users/getUsers`)
            .then((response)=>{
            commit('SET_USERS', response.data)
        })
    },
    async POST_CREATE_USER ({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/users/createUser`,
            {
                name: payload.name,
                surname: payload.surname,
                password: payload.password,
                phone: payload.phone,
                email: payload.email,
                team: payload.team
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },

    //################################### ISSUES/PRODUCT BACKLOG #####################################################
    async POST_CREATE_ISSUE ({commit,dispatch}, payload) {
        await this.$axios.$post(`http://localhost:8080/issues/createIssue`,
            {
                // sabit typelar: bug, story, task, feature, improvement, epic
                // priority: blocker, critical, major, normal, minor
                issueTitle: payload.issueTitle,
                issueDesc: payload.issueDesc,
                issueType: payload.issueType,
                issueSprintName: payload.issueSprintName,
                issuePriority: payload.issuePriority,
                issueEstimation: payload.issueEstimation,
                issueStatus: payload.issueStatus,
                issueOwner: payload.issueOwner
            }
        ).then(()=>{
            dispatch('GET_ISSUES')
        })
    },
    async POST_UPDATE_ISSUE ({commit, dispatch}, payload) {
        await this.$axios.$post(`http://localhost:8080/issues/updateIssue`, payload ).then(()=>{
            dispatch('GET_ISSUES')
        })
    },
    async POST_DELETE_ISSUE ({commit, dispatch}, payload) {
        await this.$axios.$post(`http://localhost:8080/issues/deleteIssue`, payload).then(()=>{
            dispatch('GET_ISSUES')
        })
    },
    async GET_ISSUES ({commit}) {
        await this.$axios.get(`http://localhost:8080/issues/getIssues`)
            .then((response)=>{
            commit('SET_ISSUE', response.data)
        })
    },

    //############################## LOGIN ###################################################################
    async POST_LOGIN ({commit,dispatch}, payload) {
        return await this.$axios.$post(`http://localhost:8080/login-page/login`,
            {
                //loginFlag
                password: payload.password,
                email: payload.email,
            }
        ).then((response)=>{
            console.log('response:',response)
            return response
        })
    },
    async POST_LOGIN_REGISTER ({commit,dispatch}, payload) {
        return await this.$axios.$post(`http://localhost:8080/users/createUser`,
            {
                // signUpFlag
                name: payload.name,
                surname: payload.surname,
                password: payload.password,
                phone: payload.phone,
                email: payload.email,
                team: 'Test'
            }
        ).then((response)=>{
            console.log('response:',response)
            return response
        })
    },

    //############################### SCRUM BOARD ############################################################
    async POST_CREATE_SPRINT({commit,dispatch}, payload) {
        return await this.$axios.$post(`http://localhost:8080/board/createSprint`,
            {
                // sprintName
                // sprintDesk
            }
        ).then((response)=>{
            console.log('true',response)
            return true
        }).catch((e)=>{
            console.log('error',e)
            return false
        })
    },
    async GET_LAST_SPRINT({commit,dispatch}, payload) {
        return await this.$axios.$post(`http://localhost:8080/board/getLastSprint`,
            {
                //sprinName, sprintDesc,

            }
        ).then((response)=>{
            console.log('true',response)
            return true
        }).catch((e)=>{
            console.log('error',e)
            return false
        })
    },
    async GET_LAST_SPRINT_ISSUES({commit,dispatch}, payload) {
        return await this.$axios.$post(`http://localhost:8080/board/getLastSprintIssues`,
            {
                // status dönecek ona göre ayır
                //sprinName, sprintDesc,

            }
        ).then((response)=>{
            console.log('true',response)
            return true
        }).catch((e)=>{
            console.log('error',e)
            return false
        })
    },

    //############################## SETTINGS ###################################################
}
