package com.concretepage.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.entity.Movie;
import com.concretepage.gs_ws.AddMovieRequest;
import com.concretepage.gs_ws.AddMovieResponse;
import com.concretepage.gs_ws.MovieInfo;
import com.concretepage.gs_ws.DeleteMovieRequest;
import com.concretepage.gs_ws.DeleteMovieResponse;
import com.concretepage.gs_ws.GetAllMoviesResponse;
import com.concretepage.gs_ws.GetMovieByIdRequest;
import com.concretepage.gs_ws.GetMovieByIdResponse;
import com.concretepage.gs_ws.ServiceStatusMovie;
import com.concretepage.gs_ws.UpdateMovieRequest;
import com.concretepage.gs_ws.UpdateMovieResponse;
import com.concretepage.service.IMovieService;

@Endpoint
public class MovieEndpoint {
    private static final String NAMESPACE_URI = "http://www.concretepage.com/movie-ws";
    @Autowired
    private IMovieService movieService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMovieByIdRequest")
    @ResponsePayload
    public GetMovieByIdResponse getMovie(@RequestPayload GetMovieByIdRequest request) {
        GetMovieByIdResponse response = new GetMovieByIdResponse();
        MovieInfo movieInfo = new MovieInfo();
        BeanUtils.copyProperties(movieService.getMovieById(request.getMovieId()), movieInfo);
        response.setMovieInfo(movieInfo);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMoviesRequest")
    @ResponsePayload
    public GetAllMoviesResponse getAllMovies() {
        GetAllMoviesResponse response = new GetAllMoviesResponse();
        List<MovieInfo> movieInfoList = new ArrayList<>();
        List<Movie> movieList = movieService.getAllMovies();
        for (int i = 0; i < movieList.size(); i++) {
            MovieInfo ob = new MovieInfo();
            BeanUtils.copyProperties(movieList.get(i), ob);
            movieInfoList.add(ob);
        }
        response.getMovieInfo().addAll(movieInfoList);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMovieRequest")
    @ResponsePayload
    public AddMovieResponse addMovie(@RequestPayload AddMovieRequest request) {
        AddMovieResponse response = new AddMovieResponse();
        ServiceStatusMovie ServiceStatusMovie = new ServiceStatusMovie();
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setdateProduction(request.getDateProduction());
        boolean flag = movieService.addMovie(movie);
        if (flag == false) {
            ServiceStatusMovie.setStatusCode("CONFLICT");
            ServiceStatusMovie.setMessage("Content Already Available");
            response.setServiceStatus(ServiceStatusMovie);
        } else {
            MovieInfo movieInfo = new MovieInfo();
            BeanUtils.copyProperties(movie, movieInfo);
            response.setMovieInfo(movieInfo);
            ServiceStatusMovie.setStatusCode("SUCCESS");
            ServiceStatusMovie.setMessage("Content Added Successfully");
            response.setServiceStatus(ServiceStatusMovie);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMovieRequest")
    @ResponsePayload
    public UpdateMovieResponse updateMovie(@RequestPayload UpdateMovieRequest request) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(request.getMovieInfo(), movie);
        movieService.updateMovie(movie);
        ServiceStatusMovie ServiceStatusMovie = new ServiceStatusMovie();
        ServiceStatusMovie.setStatusCode("SUCCESS");
        ServiceStatusMovie.setMessage("Content Updated Successfully");
        UpdateMovieResponse response = new UpdateMovieResponse();
        response.setServiceStatusMovie(ServiceStatusMovie);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteMovieRequest")
    @ResponsePayload
    public DeleteMovieResponse deleteMovie(@RequestPayload DeleteMovieRequest request) {
        Movie movie = movieService.getMovieById(request.getMovieId());
        ServiceStatusMovie ServiceStatusMovie = new ServiceStatusMovie();
        if (movie == null ) {
            ServiceStatusMovie.setStatusCode("FAIL");
            ServiceStatusMovie.setMessage("Content Not Available");
        } else {
            movieService.deleteMovie(movie);
            ServiceStatusMovie.setStatusCode("SUCCESS");
            ServiceStatusMovie.setMessage("Content Deleted Successfully");
        }
        DeleteMovieResponse response = new DeleteMovieResponse();
        response.setServiceStatusMovie(ServiceStatusMovie);
        return response;
    }
}
