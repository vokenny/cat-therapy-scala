package controllers

import javax.inject._
import play.api.mvc._
import services.CatApiService

import scala.concurrent.ExecutionContext

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents,
															 implicit val ec: ExecutionContext,
															 catApiService: CatApiService
															) extends BaseController {

	def index(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
		catApiService.getRandCatImage().map(catUrl => {
			Ok(views.html.index(catUrl))
		})
	}
}
