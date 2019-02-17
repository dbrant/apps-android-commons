package fr.free.nrw.commons;

import android.support.annotation.NonNull;

import org.wikipedia.AppAdapter;
import org.wikipedia.dataclient.Service;
import org.wikipedia.dataclient.SharedPreferenceCookieManager;
import org.wikipedia.dataclient.WikiSite;
import org.wikipedia.login.LoginResult;

import javax.inject.Inject;

import fr.free.nrw.commons.auth.SessionManager;
import okhttp3.OkHttpClient;

public class CommonsApplicationAdapter extends AppAdapter {
    @Inject SessionManager sessionManager;

    @Override
    public String getMediaWikiBaseUrl() {
        return Service.COMMONS_URL;
    }

    @Override
    public String getRestbaseUriFormat() {
        return Service.COMMONS_URL;
    }

    @Override
    public OkHttpClient getOkHttpClient(@NonNull WikiSite wikiSite) {
        return OkHttpConnectionFactory.getClient();
    }

    @Override
    public int getDesiredLeadImageDp() {
        return 640;
    }

    @Override
    public boolean isLoggedIn() {
        return sessionManager.isUserLoggedIn();
    }

    @Override
    public String getUserName() {
        return sessionManager.getUserName();
    }

    @Override
    public String getPassword() {
        return sessionManager.getPassword();
    }

    @Override
    public void updateAccount(@NonNull LoginResult result) {
        sessionManager.createAccount(null, result);
    }

    @Override
    public SharedPreferenceCookieManager getCookies() {
        return null;
    }

    @Override
    public void setCookies(@NonNull SharedPreferenceCookieManager cookies) {

    }

    @Override
    public boolean logErrorsInsteadOfCrashing() {
        return false;
    }
}
