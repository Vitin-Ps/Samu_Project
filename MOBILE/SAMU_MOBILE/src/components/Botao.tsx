import {Button, theme} from 'native-base';
import {ColorType} from 'native-base/lib/typescript/components/types';
import {useState, useEffect} from 'react';

interface BotaoProps {
  isLoading: boolean;
  setIsLoading: (value: boolean) => void;
  w?: string;
  clickButton?: (...args: any[]) => boolean | Promise<boolean>;
  [key: string]: any;
}

const Botao: React.FC<BotaoProps> = ({
  isLoading,
  setIsLoading,
  w,
  clickButton,
  ...rest
}) => {
  const [fundoPadrao, setFundoPadrao] = useState<ColorType>(
    theme.colors.blue[400],
  );

  useEffect(() => {
    if (isLoading) {
      setFundoPadrao(theme.colors.blue[700]);
    } else {
      setFundoPadrao(theme.colors.blue[400]);
    }
  }, [isLoading]);

  const handleClickButton = () => {
    stateClick(setIsLoading, clickButton);
  };

  return (
    <Button
      w={w || '40%'}
      p={2}
      borderRadius={10}
      isLoading={isLoading}
      onPress={handleClickButton}
      bg={fundoPadrao}
      {...rest}></Button>
  );
};

export const stateClick = async (
  setIsLoading: (valor: boolean) => void,
  clickButton?: (...args: any[]) => boolean | Promise<boolean>,
) => {
  try {
    setIsLoading(true);

    if (clickButton) {
      const functionComplete = await clickButton();
      if (functionComplete) {
        setIsLoading(false);
      }
    } else {
      setTimeout(() => {
        setIsLoading(false);
      }, 1000);
    }
  } catch (error) {
    console.error('Erro ao executar a função clickButton:', error);
    setIsLoading(false);
  }
};

export default Botao;
