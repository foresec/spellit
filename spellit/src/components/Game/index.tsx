import { useSelector } from 'react-redux';

import { RootState } from '@/store';

import Ready from './Ready'
import Attack from './Attack';
import Defense from './Defense';
import Settle from '../Settle/Settle';
import OpenViduVideo from '@/components/Game/OpenVidu/OpenVidu'


const Game = () => {
  const readyTurn = useSelector((state: RootState) => state.game.readyTurn)
  const attackTurn = useSelector((state: RootState) => state.game.attackTurn)
  const defenseTurn = useSelector((state: RootState) => state.game.defenseTurn)
  const settleTurn = useSelector((state: RootState) => state.game.settleTurn)
  

  console.log('readyTurn: ', readyTurn)
  console.log('attackTurn: ', attackTurn)
  console.log('defenseTurn: ', defenseTurn)
  console.log('settleTurn: ', settleTurn)
  return (
    <div>
      <OpenViduVideo />
      {readyTurn && <Ready />}
      {attackTurn && <Attack />}
      {defenseTurn && <Defense />}
      {settleTurn && <Settle />}
    </div>
  )
}
export default Game;