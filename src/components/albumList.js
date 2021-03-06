// Import
import React, { Component } from 'react';
import { View, ScrollView } from 'react-native';
import axios from 'axios';
import AlbumDetail from './albumDetail';
//  Create Component
class AlbumList extends Component {

  state = { albums: [] };

  componentWillMount() {
    axios.get('https://rallycoding.herokuapp.com/api/music_albums')
    .then(response => this.setState({ albums: response.data }));
  }

  renderAlbum() {
    return this.state.albums.map(album =>
        <AlbumDetail key={album.title} album={album} />
    );
  }

  render() {
    console.log(this.state);
    return (
    <ScrollView>
      <View>
        {this.renderAlbum()}
      </View>
    </ScrollView>
    );
  }
}
// Export Component
export default AlbumList;
