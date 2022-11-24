POST https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyAEZEKyLMVJEZhXgVpD3hpgdZNOH3oGBAY
Content-Type: application/json
{
  "dynamicLinkInfo": {
    "domainUriPrefix": "https://example.page.link",
    "link": "https://www.example.com/",
    "androidInfo": {
      "androidPackageName": "com.example.android"
    },
    "iosInfo": {
      "iosBundleId": "com.example.ios"
    }
  }
}


POST https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyAEZEKyLMVJEZhXgVpD3hpgdZNOH3oGBAY
Content-Type: application/json
{
   "longDynamicLink": "https://example.page.link/?link=https://www.example.com/&apn=com.example.android&ibi=com.example.ios"
}
