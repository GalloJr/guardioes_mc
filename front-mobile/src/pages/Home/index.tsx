import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, View } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import HeaderOff from '../../Components/HeaderOff';

export default function Home() {

    const navigation = useNavigation();

    const handleOnPress = () => {
        navigation.navigate('Visitors');
    }

    return (
        <>
            <HeaderOff />
            <TouchableWithoutFeedback onPress={handleOnPress}>
                <View style={styles.container}>
                    <Image source={require('../../assets/logo.png')} />
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
