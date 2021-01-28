import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, View } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import Header from '../Header';

export default function Schedule() {

    const navigation = useNavigation();

    const handleOnPress = () => {
        navigation.navigate('Menu');
    }
    
    return (
        <>
            <Header />
            <TouchableWithoutFeedback onPress={handleOnPress}>
            <View style={styles.container}>
                <Image source={require('../assets/ucl.png')}/>
            </View>
            </TouchableWithoutFeedback>
        </>

    );
}

const styles = StyleSheet.create(
    {
        container: {
            marginTop: '23%',
            alignItems: 'center'
        }
    }
);
