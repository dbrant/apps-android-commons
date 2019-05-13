package fr.free.nrw.commons.utils;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import fr.free.nrw.commons.location.LatLng;

@Singleton
public class ImageUtilsWrapper {

    @Inject
    public ImageUtilsWrapper() {

    }

    public Single<Integer> checkImageBitmapIssues(String bitmapPath) {
        return Single.fromCallable(() -> ImageUtils.checkImageBitmapIssues(bitmapPath))
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());
    }

    public Single<Integer> checkImageGeolocationIsDifferent(String geolocationOfFileString, LatLng latLng) {
        boolean isImageGeoLocationDifferent = ImageUtils.checkImageGeolocationIsDifferent(geolocationOfFileString, latLng);
        return Single.just(isImageGeoLocationDifferent)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .map(isDifferent -> isDifferent ? ImageUtils.IMAGE_GEOLOCATION_DIFFERENT : ImageUtils.IMAGE_OK);
    }
}
