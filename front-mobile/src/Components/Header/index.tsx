import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';

export default function Header() {
  const navigation = useNavigation();

  const handleOnPress = () => {
      navigation.navigate('Menu');
  }

  return (
    <TouchableWithoutFeedback onPress={handleOnPress}>
      <View style={styles.container}>
        <Text style={styles.text}>Guardiões M.C.</Text>
      </View>
    </TouchableWithoutFeedback>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#FF0000',
    height: 90,
    paddingTop: 50,
    flexDirection: 'row',
    justifyContent: 'center'
  },
  text: {
    fontWeight: 'bold',
    fontSize: 23,
    lineHeight: 25,
    letterSpacing: -0.24,
    color: '#FFF'
  }
});
