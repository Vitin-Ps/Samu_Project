import {KeyboardAvoidingView, Text} from 'native-base';
import Botao from '../components/Botao';
import {useState} from 'react';

const Home = () => {
  const [isloading, setIsloading] = useState<boolean>(false);
  return (
    <KeyboardAvoidingView>
      <Text m={5}>Hello World</Text>
      <Botao isLoading={isloading} setIsLoading={setIsloading} m={10}>
        <Text>TESTE</Text>
      </Botao>
    </KeyboardAvoidingView>
  );
};

export default Home;
