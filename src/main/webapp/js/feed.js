var feed = new Vue({
  el: '#app',
  data () {
    return {
      images: []
    }
  },
  mounted () {
    axios
      .get('https://inst4gram.herokuapp.com/api/feed/0')
      .then(response => {
        this.images = response.data
        console.log(this.images)
      })
  }
})

