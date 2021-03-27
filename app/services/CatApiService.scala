package services

import connectors.CatApiConnector
import javax.inject._

import scala.concurrent.{ExecutionContext, Future}

class CatApiService @Inject()(catApiConnector: CatApiConnector, implicit val ec: ExecutionContext) {

	def getRandCatImage(breedName: Option[String] = None): Future[String] = {
		breedName match {
			case Some(name) => ???
			case None => catApiConnector.getRandomCat.map(res => (res.json.head \ "url").as[String])
		}
	}
}
