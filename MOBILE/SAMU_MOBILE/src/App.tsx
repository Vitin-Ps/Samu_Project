import Routes from './Routes';
import { NativeBaseProvider, StatusBar, theme } from 'native-base';

const App = () => {
  return (
   <NativeBaseProvider theme={theme}>
    <StatusBar backgroundColor={theme.colors.gray[400]}/>
    <Routes/>
   </NativeBaseProvider>
  );
};

export default App;
