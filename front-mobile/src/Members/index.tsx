import React, { useEffect, useState } from 'react';
import { StyleSheet, Alert, Text } from 'react-native';
import { ScrollView, TouchableWithoutFeedback } from 'react-native-gesture-handler';
import Header from '../Header';
import MemberCard from '../MemberCard';
import { fetchMembers } from '../api';
import { Member } from '../types';
import { useIsFocused, useNavigation } from '@react-navigation/native';

export default function Members() {
    const [members, setMembers] = useState<Member[]>([]);
    const [isLoading, setIsLoading] = useState(false);
    const navigation = useNavigation();
    const isFocused = useIsFocused();
    
    const fetchData = () =>{
        setIsLoading(true);
        fetchMembers()
            .then(response => setMembers(response.data))
            .catch(error => Alert.alert('Houve um erro ao buscar os integrantes!'))
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
                <Text> Buscando integrantes...</Text>
            ) : (
                members.map(member => (
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
