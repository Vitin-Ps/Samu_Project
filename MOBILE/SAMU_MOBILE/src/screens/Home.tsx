import { KeyboardAvoidingView } from 'react-native'
import { Text } from '@/components/ui/text';


const Home = () => {
  return (
    <KeyboardAvoidingView>
      <Text className='text-blue-400 text-5xl m-5' size='2xl'>Hello World</Text>
    </KeyboardAvoidingView>
  )
}

export default Home