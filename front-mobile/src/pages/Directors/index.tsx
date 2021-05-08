import React, { useEffect, useState } from 'react';
import { StyleSheet, Alert, Text } from 'react-native';
import { ScrollView, TouchableWithoutFeedback } from 'react-native-gesture-handler';
import Header from '../../Components/Header';
import MemberCard from '../../Components/MemberCard';
import { fetchDirectors } from '../../api';
import { Member } from '../../types/types';
import { useIsFocused, useNavigation } from '@react-navigation/native';

export default function Directors() {
    const [directors, setDirectors] = useState<Member[]>([]);
    const [isLoading, setIsLoading] = useState(false);
    const navigation = useNavigation();
    const isFocused = useIsFocused();

    const fetchData = () => {
        setIsLoading(true);
        fetchDirectors()
            .then(response => setDirectors(response.data))
            .catch(error => Alert.alert('Houve um erro ao buscar os Diretores!'))
            .finally(() => setIsLoading(false));
    }

    useEffect(() => {
        if (isFocused) {
            fetchData();
        }
    }, [isFocused]);

    const handleOnPress = (member: Member) => {
        navigation.navigate('MemberDetails', {
            member
        });
    }

    return (
        <>
            <Header />
            <ScrollView style={styles.container}>
                {isLoading ? (
                    <Text> Buscando membros da diretoria...</Text>
                ) : (
                    directors.map(member => (
                        <TouchableWithoutFeedback
                            key={member.id}
                            onPress={() => handleOnPress(member)}
                        >
                            <MemberCard member={member} />
                        </TouchableWithoutFeedback>
                    ))
                )}
            </ScrollView>
        </>

    );
}

const styles = StyleSheet.create({
    container: {
        paddingRight: '5%',
        paddingLeft: '5%'
    }
});
