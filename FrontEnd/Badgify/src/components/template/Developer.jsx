import DevCard from '../module/DevCard';
import { devData } from '../../data/DeveloperData';
import style from '../template/Developer.module.css';
function Developer() {
  return (
    <>
      <div className={style.container}>
        <h1>Meet our team</h1>
        <div className={style.card}>
          {devData.map(i => (
            <DevCard key={i.id} data={i} />
          ))}
        </div>
      </div>
    </>
  );
}

export default Developer;
