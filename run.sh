#!/usr/bin/env bash
cd src/main/webapp/resources/vendors
if ! [ -d bower_components ]; then
bower install
fi
if ! [ -d node_modules ]; then
npm install
fi
