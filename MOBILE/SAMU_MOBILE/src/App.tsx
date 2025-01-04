import {GluestackUIProvider} from '@/components/ui/gluestack-ui-provider';
import {StatusBar} from 'react-native';
import Routes from './Routes';

const App = () => {
  return (
    <GluestackUIProvider mode="light">
      <StatusBar />
      <Routes />
    </GluestackUIProvider>
  );
};

export default App;
