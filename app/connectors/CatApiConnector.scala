package connectors

import javax.inject.Inject
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.Future
import scala.concurrent.duration._

class CatApiConnector @Inject()(ws: WSClient) {

	val defaultTimeout: FiniteDuration = 10000.milliseconds

	val baseUrl: String = "https://api.thecatapi.com/v1"

	def getRandomCat: Future[WSResponse] = {
		ws.url(baseUrl + "/images/search")
			.withRequestTimeout(defaultTimeout)
			.get()
	}
}
