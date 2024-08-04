
import DevCard from '../module/DevCard'
import { devData } from '../../data/DeveloperData'
import style from "../template/Developer.module.css"
function Developer() {
  console.log(devData)
  return (
    <>
            <h1>Meet out team</h1>
      <div className={style.container}>

        {devData.map((i) => (
      <DevCard key={i.id} data={i} />
    ))}
      </div>
    </>
  )
}

export default Developer
