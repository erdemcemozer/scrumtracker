export const state = ()=> ({

    navbarToggle: false,
    miniVariant: false,
    pageTitle: null,
    usefulLinks: null,
    announcements: null,
    sprint: null,
    meeting: null,

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
    async POST_MEETING_RESULTS({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/meetingResults/createMeeting`,
            {
                title: payload.title,
                description: payload.description,
                meetingDate: payload.meetingDate,
                //meetingType
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async POST_MEETING_RESULTS_UPDATE({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/meetingResults/updateMeeting`,
            {
                title: payload.title,
                description: payload.description,
                meetingDate: payload.meetingDate,
                //meetingType
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async POST_MEETING_RESULTS_DELETE({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/meetingResults/deleteMeeting`,
            {
                title: payload.title,
                description: payload.description,
                meetingDate: payload.meetingDate,
                //meetingType
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async GET_MEETING_RESULTS_LIST({commit}, payload) {
        // typa göre ayır
        await this.$axios.$post(`http://localhost:8080/meetingResults/getMeetingResults`,
            {
                title: payload.title,
                description: payload.description,
                meetingDate: payload.meetingDate,
                //meetingType
            }
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async POST_USER_UPDATE({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/users/updateUser`,
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
    async POST_USERS ({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/users/getUsers`,
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
    async POST_CREATE_ISSUE ({commit}, payload) {
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
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async POST_UPDATE_ISSUE ({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/issues/updateIssue`,
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
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async POST_DELETE_ISSUE ({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/issues/deleteIssue`,
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
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
    async GET_ISSUEs ({commit}, payload) {
        await this.$axios.$post(`http://localhost:8080/issues/getIssues`,
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
        ).then((response)=>{
            commit('SET_MEETING', response.data)
        })
    },
}
