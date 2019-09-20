["^ ","~:resource-id",["~:shadow.build.classpath/resource","goog/structs/structs.js"],"~:js","/**\n * @suppress {strictMissingProperties}\n */\ngoog.provide(\"goog.structs\");\ngoog.require(\"goog.array\");\ngoog.require(\"goog.object\");\n/**\n * @param {Object} col\n * @return {number}\n */\ngoog.structs.getCount = function(col) {\n  if (col.getCount && typeof col.getCount == \"function\") {\n    return col.getCount();\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return col.length;\n  }\n  return goog.object.getCount(col);\n};\n/**\n * @param {Object} col\n * @return {!Array<?>}\n */\ngoog.structs.getValues = function(col) {\n  if (col.getValues && typeof col.getValues == \"function\") {\n    return col.getValues();\n  }\n  if (goog.isString(col)) {\n    return col.split(\"\");\n  }\n  if (goog.isArrayLike(col)) {\n    var rv = [];\n    var l = col.length;\n    for (var i = 0; i < l; i++) {\n      rv.push(col[i]);\n    }\n    return rv;\n  }\n  return goog.object.getValues(col);\n};\n/**\n * @param {Object} col\n * @return {(!Array|undefined)}\n */\ngoog.structs.getKeys = function(col) {\n  if (col.getKeys && typeof col.getKeys == \"function\") {\n    return col.getKeys();\n  }\n  if (col.getValues && typeof col.getValues == \"function\") {\n    return undefined;\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    var rv = [];\n    var l = col.length;\n    for (var i = 0; i < l; i++) {\n      rv.push(i);\n    }\n    return rv;\n  }\n  return goog.object.getKeys(col);\n};\n/**\n * @param {Object} col\n * @param {*} val\n * @return {boolean}\n */\ngoog.structs.contains = function(col, val) {\n  if (col.contains && typeof col.contains == \"function\") {\n    return col.contains(val);\n  }\n  if (col.containsValue && typeof col.containsValue == \"function\") {\n    return col.containsValue(val);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.contains(/** @type {!Array<?>} */ (col), val);\n  }\n  return goog.object.containsValue(col, val);\n};\n/**\n * @param {Object} col\n * @return {boolean}\n */\ngoog.structs.isEmpty = function(col) {\n  if (col.isEmpty && typeof col.isEmpty == \"function\") {\n    return col.isEmpty();\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.isEmpty(/** @type {!Array<?>} */ (col));\n  }\n  return goog.object.isEmpty(col);\n};\n/**\n * @param {Object} col\n */\ngoog.structs.clear = function(col) {\n  if (col.clear && typeof col.clear == \"function\") {\n    col.clear();\n  } else {\n    if (goog.isArrayLike(col)) {\n      goog.array.clear(/** @type {IArrayLike<?>} */ (col));\n    } else {\n      goog.object.clear(col);\n    }\n  }\n};\n/**\n * @param {S} col\n * @param {function(this:T,?,?,S):?} f\n * @param {T=} opt_obj\n * @template T, S\n * @deprecated Use a more specific method, e.g. goog.array.forEach, goog.object.forEach, or for-of.\n */\ngoog.structs.forEach = function(col, f, opt_obj) {\n  if (col.forEach && typeof col.forEach == \"function\") {\n    col.forEach(f, opt_obj);\n  } else {\n    if (goog.isArrayLike(col) || goog.isString(col)) {\n      goog.array.forEach(/** @type {!Array<?>} */ (col), f, opt_obj);\n    } else {\n      var keys = goog.structs.getKeys(col);\n      var values = goog.structs.getValues(col);\n      var l = values.length;\n      for (var i = 0; i < l; i++) {\n        f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col);\n      }\n    }\n  }\n};\n/**\n * @param {S} col\n * @param {function(this:T,?,?,S):boolean} f\n * @param {T=} opt_obj\n * @return {(!Object|!Array<?>)}\n * @template T, S\n */\ngoog.structs.filter = function(col, f, opt_obj) {\n  if (typeof col.filter == \"function\") {\n    return col.filter(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.filter(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n  var rv;\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  if (keys) {\n    rv = {};\n    for (var i = 0; i < l; i++) {\n      if (f.call(/** @type {?} */ (opt_obj), values[i], keys[i], col)) {\n        rv[keys[i]] = values[i];\n      }\n    }\n  } else {\n    rv = [];\n    for (var i = 0; i < l; i++) {\n      if (f.call(opt_obj, values[i], undefined, col)) {\n        rv.push(values[i]);\n      }\n    }\n  }\n  return rv;\n};\n/**\n * @param {S} col\n * @param {function(this:T,?,?,S):V} f\n * @param {T=} opt_obj\n * @return {(!Object<?,V>|!Array<V>)}\n * @template T, S, V\n */\ngoog.structs.map = function(col, f, opt_obj) {\n  if (typeof col.map == \"function\") {\n    return col.map(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.map(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n  var rv;\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  if (keys) {\n    rv = {};\n    for (var i = 0; i < l; i++) {\n      rv[keys[i]] = f.call(/** @type {?} */ (opt_obj), values[i], keys[i], col);\n    }\n  } else {\n    rv = [];\n    for (var i = 0; i < l; i++) {\n      rv[i] = f.call(/** @type {?} */ (opt_obj), values[i], undefined, col);\n    }\n  }\n  return rv;\n};\n/**\n * @param {S} col\n * @param {function(this:T,?,?,S):boolean} f\n * @param {T=} opt_obj\n * @return {boolean}\n * @template T, S\n */\ngoog.structs.some = function(col, f, opt_obj) {\n  if (typeof col.some == \"function\") {\n    return col.some(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.some(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  for (var i = 0; i < l; i++) {\n    if (f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col)) {\n      return true;\n    }\n  }\n  return false;\n};\n/**\n * @param {S} col\n * @param {function(this:T,?,?,S):boolean} f\n * @param {T=} opt_obj\n * @return {boolean}\n * @template T, S\n */\ngoog.structs.every = function(col, f, opt_obj) {\n  if (typeof col.every == \"function\") {\n    return col.every(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.every(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  for (var i = 0; i < l; i++) {\n    if (!f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col)) {\n      return false;\n    }\n  }\n  return true;\n};\n","~:source","// Copyright 2006 The Closure Library Authors. All Rights Reserved.\n//\n// Licensed under the Apache License, Version 2.0 (the \"License\");\n// you may not use this file except in compliance with the License.\n// You may obtain a copy of the License at\n//\n//      http://www.apache.org/licenses/LICENSE-2.0\n//\n// Unless required by applicable law or agreed to in writing, software\n// distributed under the License is distributed on an \"AS-IS\" BASIS,\n// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n// See the License for the specific language governing permissions and\n// limitations under the License.\n\n/**\n * @fileoverview Generics method for collection-like classes and objects.\n *\n * @author arv@google.com (Erik Arvidsson)\n *\n * This file contains functions to work with collections. It supports using\n * Map, Set, Array and Object and other classes that implement collection-like\n * methods.\n * @suppress {strictMissingProperties}\n */\n\n\ngoog.provide('goog.structs');\n\ngoog.require('goog.array');\ngoog.require('goog.object');\n\n\n// We treat an object as a dictionary if it has getKeys or it is an object that\n// isn't arrayLike.\n\n\n/**\n * Returns the number of values in the collection-like object.\n * @param {Object} col The collection-like object.\n * @return {number} The number of values in the collection-like object.\n */\ngoog.structs.getCount = function(col) {\n  if (col.getCount && typeof col.getCount == 'function') {\n    return col.getCount();\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return col.length;\n  }\n  return goog.object.getCount(col);\n};\n\n\n/**\n * Returns the values of the collection-like object.\n * @param {Object} col The collection-like object.\n * @return {!Array<?>} The values in the collection-like object.\n */\ngoog.structs.getValues = function(col) {\n  if (col.getValues && typeof col.getValues == 'function') {\n    return col.getValues();\n  }\n  if (goog.isString(col)) {\n    return col.split('');\n  }\n  if (goog.isArrayLike(col)) {\n    var rv = [];\n    var l = col.length;\n    for (var i = 0; i < l; i++) {\n      rv.push(col[i]);\n    }\n    return rv;\n  }\n  return goog.object.getValues(col);\n};\n\n\n/**\n * Returns the keys of the collection. Some collections have no notion of\n * keys/indexes and this function will return undefined in those cases.\n * @param {Object} col The collection-like object.\n * @return {!Array|undefined} The keys in the collection.\n */\ngoog.structs.getKeys = function(col) {\n  if (col.getKeys && typeof col.getKeys == 'function') {\n    return col.getKeys();\n  }\n  // if we have getValues but no getKeys we know this is a key-less collection\n  if (col.getValues && typeof col.getValues == 'function') {\n    return undefined;\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    var rv = [];\n    var l = col.length;\n    for (var i = 0; i < l; i++) {\n      rv.push(i);\n    }\n    return rv;\n  }\n\n  return goog.object.getKeys(col);\n};\n\n\n/**\n * Whether the collection contains the given value. This is O(n) and uses\n * equals (==) to test the existence.\n * @param {Object} col The collection-like object.\n * @param {*} val The value to check for.\n * @return {boolean} True if the map contains the value.\n */\ngoog.structs.contains = function(col, val) {\n  if (col.contains && typeof col.contains == 'function') {\n    return col.contains(val);\n  }\n  if (col.containsValue && typeof col.containsValue == 'function') {\n    return col.containsValue(val);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.contains(/** @type {!Array<?>} */ (col), val);\n  }\n  return goog.object.containsValue(col, val);\n};\n\n\n/**\n * Whether the collection is empty.\n * @param {Object} col The collection-like object.\n * @return {boolean} True if empty.\n */\ngoog.structs.isEmpty = function(col) {\n  if (col.isEmpty && typeof col.isEmpty == 'function') {\n    return col.isEmpty();\n  }\n\n  // We do not use goog.string.isEmptyOrWhitespace because here we treat the\n  // string as\n  // collection and as such even whitespace matters\n\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.isEmpty(/** @type {!Array<?>} */ (col));\n  }\n  return goog.object.isEmpty(col);\n};\n\n\n/**\n * Removes all the elements from the collection.\n * @param {Object} col The collection-like object.\n */\ngoog.structs.clear = function(col) {\n  // NOTE(arv): This should not contain strings because strings are immutable\n  if (col.clear && typeof col.clear == 'function') {\n    col.clear();\n  } else if (goog.isArrayLike(col)) {\n    goog.array.clear(/** @type {IArrayLike<?>} */ (col));\n  } else {\n    goog.object.clear(col);\n  }\n};\n\n\n/**\n * Calls a function for each value in a collection. The function takes\n * three arguments; the value, the key and the collection.\n *\n * @param {S} col The collection-like object.\n * @param {function(this:T,?,?,S):?} f The function to call for every value.\n *     This function takes\n *     3 arguments (the value, the key or undefined if the collection has no\n *     notion of keys, and the collection) and the return value is irrelevant.\n * @param {T=} opt_obj The object to be used as the value of 'this'\n *     within `f`.\n * @template T,S\n * @deprecated Use a more specific method, e.g. goog.array.forEach,\n *     goog.object.forEach, or for-of.\n */\ngoog.structs.forEach = function(col, f, opt_obj) {\n  if (col.forEach && typeof col.forEach == 'function') {\n    col.forEach(f, opt_obj);\n  } else if (goog.isArrayLike(col) || goog.isString(col)) {\n    goog.array.forEach(/** @type {!Array<?>} */ (col), f, opt_obj);\n  } else {\n    var keys = goog.structs.getKeys(col);\n    var values = goog.structs.getValues(col);\n    var l = values.length;\n    for (var i = 0; i < l; i++) {\n      f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col);\n    }\n  }\n};\n\n\n/**\n * Calls a function for every value in the collection. When a call returns true,\n * adds the value to a new collection (Array is returned by default).\n *\n * @param {S} col The collection-like object.\n * @param {function(this:T,?,?,S):boolean} f The function to call for every\n *     value. This function takes\n *     3 arguments (the value, the key or undefined if the collection has no\n *     notion of keys, and the collection) and should return a Boolean. If the\n *     return value is true the value is added to the result collection. If it\n *     is false the value is not included.\n * @param {T=} opt_obj The object to be used as the value of 'this'\n *     within `f`.\n * @return {!Object|!Array<?>} A new collection where the passed values are\n *     present. If col is a key-less collection an array is returned.  If col\n *     has keys and values a plain old JS object is returned.\n * @template T,S\n */\ngoog.structs.filter = function(col, f, opt_obj) {\n  if (typeof col.filter == 'function') {\n    return col.filter(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.filter(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n\n  var rv;\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  if (keys) {\n    rv = {};\n    for (var i = 0; i < l; i++) {\n      if (f.call(/** @type {?} */ (opt_obj), values[i], keys[i], col)) {\n        rv[keys[i]] = values[i];\n      }\n    }\n  } else {\n    // We should not use goog.array.filter here since we want to make sure that\n    // the index is undefined as well as make sure that col is passed to the\n    // function.\n    rv = [];\n    for (var i = 0; i < l; i++) {\n      if (f.call(opt_obj, values[i], undefined, col)) {\n        rv.push(values[i]);\n      }\n    }\n  }\n  return rv;\n};\n\n\n/**\n * Calls a function for every value in the collection and adds the result into a\n * new collection (defaults to creating a new Array).\n *\n * @param {S} col The collection-like object.\n * @param {function(this:T,?,?,S):V} f The function to call for every value.\n *     This function takes 3 arguments (the value, the key or undefined if the\n *     collection has no notion of keys, and the collection) and should return\n *     something. The result will be used as the value in the new collection.\n * @param {T=} opt_obj  The object to be used as the value of 'this'\n *     within `f`.\n * @return {!Object<V>|!Array<V>} A new collection with the new values.  If\n *     col is a key-less collection an array is returned.  If col has keys and\n *     values a plain old JS object is returned.\n * @template T,S,V\n */\ngoog.structs.map = function(col, f, opt_obj) {\n  if (typeof col.map == 'function') {\n    return col.map(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.map(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n\n  var rv;\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  if (keys) {\n    rv = {};\n    for (var i = 0; i < l; i++) {\n      rv[keys[i]] = f.call(/** @type {?} */ (opt_obj), values[i], keys[i], col);\n    }\n  } else {\n    // We should not use goog.array.map here since we want to make sure that\n    // the index is undefined as well as make sure that col is passed to the\n    // function.\n    rv = [];\n    for (var i = 0; i < l; i++) {\n      rv[i] = f.call(/** @type {?} */ (opt_obj), values[i], undefined, col);\n    }\n  }\n  return rv;\n};\n\n\n/**\n * Calls f for each value in a collection. If any call returns true this returns\n * true (without checking the rest). If all returns false this returns false.\n *\n * @param {S} col The collection-like object.\n * @param {function(this:T,?,?,S):boolean} f The function to call for every\n *     value. This function takes 3 arguments (the value, the key or undefined\n *     if the collection has no notion of keys, and the collection) and should\n *     return a boolean.\n * @param {T=} opt_obj  The object to be used as the value of 'this'\n *     within `f`.\n * @return {boolean} True if any value passes the test.\n * @template T,S\n */\ngoog.structs.some = function(col, f, opt_obj) {\n  if (typeof col.some == 'function') {\n    return col.some(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.some(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  for (var i = 0; i < l; i++) {\n    if (f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col)) {\n      return true;\n    }\n  }\n  return false;\n};\n\n\n/**\n * Calls f for each value in a collection. If all calls return true this return\n * true this returns true. If any returns false this returns false at this point\n *  and does not continue to check the remaining values.\n *\n * @param {S} col The collection-like object.\n * @param {function(this:T,?,?,S):boolean} f The function to call for every\n *     value. This function takes 3 arguments (the value, the key or\n *     undefined if the collection has no notion of keys, and the collection)\n *     and should return a boolean.\n * @param {T=} opt_obj  The object to be used as the value of 'this'\n *     within `f`.\n * @return {boolean} True if all key-value pairs pass the test.\n * @template T,S\n */\ngoog.structs.every = function(col, f, opt_obj) {\n  if (typeof col.every == 'function') {\n    return col.every(f, opt_obj);\n  }\n  if (goog.isArrayLike(col) || goog.isString(col)) {\n    return goog.array.every(/** @type {!Array<?>} */ (col), f, opt_obj);\n  }\n  var keys = goog.structs.getKeys(col);\n  var values = goog.structs.getValues(col);\n  var l = values.length;\n  for (var i = 0; i < l; i++) {\n    if (!f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col)) {\n      return false;\n    }\n  }\n  return true;\n};\n","~:compiled-at",1568955482905,"~:source-map-json","{\n\"version\":3,\n\"file\":\"goog.structs.structs.js\",\n\"lineCount\":243,\n\"mappings\":\"A;;;AA0BAA,IAAAC,QAAA,CAAa,cAAb,CAAA;AAEAD,IAAAE,QAAA,CAAa,YAAb,CAAA;AACAF,IAAAE,QAAA,CAAa,aAAb,CAAA;AAYA;;;;AAAAF,IAAAG,QAAAC,SAAA,GAAwBC,QAAQ,CAACC,GAAD,CAAM;AACpC,MAAIA,GAAAF,SAAJ,IAAoB,MAAOE,IAAAF,SAA3B,IAA2C,UAA3C;AACE,WAAOE,GAAAF,SAAA,EAAP;AADF;AAGA,MAAIJ,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAOA,GAAAG,OAAP;AADF;AAGA,SAAOT,IAAAU,OAAAN,SAAA,CAAqBE,GAArB,CAAP;AAPoC,CAAtC;AAgBA;;;;AAAAN,IAAAG,QAAAQ,UAAA,GAAyBC,QAAQ,CAACN,GAAD,CAAM;AACrC,MAAIA,GAAAK,UAAJ,IAAqB,MAAOL,IAAAK,UAA5B,IAA6C,UAA7C;AACE,WAAOL,GAAAK,UAAA,EAAP;AADF;AAGA,MAAIX,IAAAQ,SAAA,CAAcF,GAAd,CAAJ;AACE,WAAOA,GAAAO,MAAA,CAAU,EAAV,CAAP;AADF;AAGA,MAAIb,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,CAA2B;AACzB,QAAIQ,KAAK,EAAT;AACA,QAAIC,IAAIT,GAAAG,OAAR;AACA,SAAK,IAAIO,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACEF,QAAAG,KAAA,CAAQX,GAAA,CAAIU,CAAJ,CAAR,CAAA;AADF;AAGA,WAAOF,EAAP;AANyB;AAQ3B,SAAOd,IAAAU,OAAAC,UAAA,CAAsBL,GAAtB,CAAP;AAfqC,CAAvC;AAyBA;;;;AAAAN,IAAAG,QAAAe,QAAA,GAAuBC,QAAQ,CAACb,GAAD,CAAM;AACnC,MAAIA,GAAAY,QAAJ,IAAmB,MAAOZ,IAAAY,QAA1B,IAAyC,UAAzC;AACE,WAAOZ,GAAAY,QAAA,EAAP;AADF;AAIA,MAAIZ,GAAAK,UAAJ,IAAqB,MAAOL,IAAAK,UAA5B,IAA6C,UAA7C;AACE,WAAOS,SAAP;AADF;AAGA,MAAIpB,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B,CAAiD;AAC/C,QAAIQ,KAAK,EAAT;AACA,QAAIC,IAAIT,GAAAG,OAAR;AACA,SAAK,IAAIO,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACEF,QAAAG,KAAA,CAAQD,CAAR,CAAA;AADF;AAGA,WAAOF,EAAP;AAN+C;AASjD,SAAOd,IAAAU,OAAAQ,QAAA,CAAoBZ,GAApB,CAAP;AAjBmC,CAArC;AA4BA;;;;;AAAAN,IAAAG,QAAAkB,SAAA,GAAwBC,QAAQ,CAAChB,GAAD,EAAMiB,GAAN,CAAW;AACzC,MAAIjB,GAAAe,SAAJ,IAAoB,MAAOf,IAAAe,SAA3B,IAA2C,UAA3C;AACE,WAAOf,GAAAe,SAAA,CAAaE,GAAb,CAAP;AADF;AAGA,MAAIjB,GAAAkB,cAAJ,IAAyB,MAAOlB,IAAAkB,cAAhC,IAAqD,UAArD;AACE,WAAOlB,GAAAkB,cAAA,CAAkBD,GAAlB,CAAP;AADF;AAGA,MAAIvB,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAON,IAAAyB,MAAAJ,SAAA,0BAA6C,CAACf,GAAD,CAA7C,EAAoDiB,GAApD,CAAP;AADF;AAGA,SAAOvB,IAAAU,OAAAc,cAAA,CAA0BlB,GAA1B,EAA+BiB,GAA/B,CAAP;AAVyC,CAA3C;AAmBA;;;;AAAAvB,IAAAG,QAAAuB,QAAA,GAAuBC,QAAQ,CAACrB,GAAD,CAAM;AACnC,MAAIA,GAAAoB,QAAJ,IAAmB,MAAOpB,IAAAoB,QAA1B,IAAyC,UAAzC;AACE,WAAOpB,GAAAoB,QAAA,EAAP;AADF;AAQA,MAAI1B,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAON,IAAAyB,MAAAC,QAAA,0BAA4C,CAACpB,GAAD,CAA5C,CAAP;AADF;AAGA,SAAON,IAAAU,OAAAgB,QAAA,CAAoBpB,GAApB,CAAP;AAZmC,CAArC;AAoBA;;;AAAAN,IAAAG,QAAAyB,MAAA,GAAqBC,QAAQ,CAACvB,GAAD,CAAM;AAEjC,MAAIA,GAAAsB,MAAJ,IAAiB,MAAOtB,IAAAsB,MAAxB,IAAqC,UAArC;AACEtB,OAAAsB,MAAA,EAAA;AADF;AAEO,QAAI5B,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ;AACLN,UAAAyB,MAAAG,MAAA,8BAA8C,CAACtB,GAAD,CAA9C,CAAA;AADK;AAGLN,UAAAU,OAAAkB,MAAA,CAAkBtB,GAAlB,CAAA;AAHK;AAFP;AAFiC,CAAnC;AA2BA;;;;;;;AAAAN,IAAAG,QAAA2B,QAAA,GAAuBC,QAAQ,CAACzB,GAAD,EAAM0B,CAAN,EAASC,OAAT,CAAkB;AAC/C,MAAI3B,GAAAwB,QAAJ,IAAmB,MAAOxB,IAAAwB,QAA1B,IAAyC,UAAzC;AACExB,OAAAwB,QAAA,CAAYE,CAAZ,EAAeC,OAAf,CAAA;AADF;AAEO,QAAIjC,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACLN,UAAAyB,MAAAK,QAAA,0BAA4C,CAACxB,GAAD,CAA5C,EAAmD0B,CAAnD,EAAsDC,OAAtD,CAAA;AADK,UAEA;AACL,UAAIC,OAAOlC,IAAAG,QAAAe,QAAA,CAAqBZ,GAArB,CAAX;AACA,UAAI6B,SAASnC,IAAAG,QAAAQ,UAAA,CAAuBL,GAAvB,CAAb;AACA,UAAIS,IAAIoB,MAAA1B,OAAR;AACA,WAAK,IAAIO,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACEgB,SAAAI,KAAA,kBAAwB,CAACH,OAAD,CAAxB,EAAmCE,MAAA,CAAOnB,CAAP,CAAnC,EAA8CkB,IAA9C,IAAsDA,IAAA,CAAKlB,CAAL,CAAtD,EAA+DV,GAA/D,CAAA;AADF;AAJK;AAJP;AAD+C,CAAjD;AAkCA;;;;;;;AAAAN,IAAAG,QAAAkC,OAAA,GAAsBC,QAAQ,CAAChC,GAAD,EAAM0B,CAAN,EAASC,OAAT,CAAkB;AAC9C,MAAI,MAAO3B,IAAA+B,OAAX,IAAyB,UAAzB;AACE,WAAO/B,GAAA+B,OAAA,CAAWL,CAAX,EAAcC,OAAd,CAAP;AADF;AAGA,MAAIjC,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAON,IAAAyB,MAAAY,OAAA,0BAA2C,CAAC/B,GAAD,CAA3C,EAAkD0B,CAAlD,EAAqDC,OAArD,CAAP;AADF;AAIA,MAAInB,EAAJ;AACA,MAAIoB,OAAOlC,IAAAG,QAAAe,QAAA,CAAqBZ,GAArB,CAAX;AACA,MAAI6B,SAASnC,IAAAG,QAAAQ,UAAA,CAAuBL,GAAvB,CAAb;AACA,MAAIS,IAAIoB,MAAA1B,OAAR;AACA,MAAIyB,IAAJ,CAAU;AACRpB,MAAA,GAAK,EAAL;AACA,SAAK,IAAIE,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACE,UAAIgB,CAAAI,KAAA,kBAAwB,CAACH,OAAD,CAAxB,EAAmCE,MAAA,CAAOnB,CAAP,CAAnC,EAA8CkB,IAAA,CAAKlB,CAAL,CAA9C,EAAuDV,GAAvD,CAAJ;AACEQ,UAAA,CAAGoB,IAAA,CAAKlB,CAAL,CAAH,CAAA,GAAcmB,MAAA,CAAOnB,CAAP,CAAd;AADF;AADF;AAFQ,GAAV,KAOO;AAILF,MAAA,GAAK,EAAL;AACA,SAAK,IAAIE,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACE,UAAIgB,CAAAI,KAAA,CAAOH,OAAP,EAAgBE,MAAA,CAAOnB,CAAP,CAAhB,EAA2BI,SAA3B,EAAsCd,GAAtC,CAAJ;AACEQ,UAAAG,KAAA,CAAQkB,MAAA,CAAOnB,CAAP,CAAR,CAAA;AADF;AADF;AALK;AAWP,SAAOF,EAAP;AA9B8C,CAAhD;AAkDA;;;;;;;AAAAd,IAAAG,QAAAoC,IAAA,GAAmBC,QAAQ,CAAClC,GAAD,EAAM0B,CAAN,EAASC,OAAT,CAAkB;AAC3C,MAAI,MAAO3B,IAAAiC,IAAX,IAAsB,UAAtB;AACE,WAAOjC,GAAAiC,IAAA,CAAQP,CAAR,EAAWC,OAAX,CAAP;AADF;AAGA,MAAIjC,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAON,IAAAyB,MAAAc,IAAA,0BAAwC,CAACjC,GAAD,CAAxC,EAA+C0B,CAA/C,EAAkDC,OAAlD,CAAP;AADF;AAIA,MAAInB,EAAJ;AACA,MAAIoB,OAAOlC,IAAAG,QAAAe,QAAA,CAAqBZ,GAArB,CAAX;AACA,MAAI6B,SAASnC,IAAAG,QAAAQ,UAAA,CAAuBL,GAAvB,CAAb;AACA,MAAIS,IAAIoB,MAAA1B,OAAR;AACA,MAAIyB,IAAJ,CAAU;AACRpB,MAAA,GAAK,EAAL;AACA,SAAK,IAAIE,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACEF,QAAA,CAAGoB,IAAA,CAAKlB,CAAL,CAAH,CAAA,GAAcgB,CAAAI,KAAA,kBAAwB,CAACH,OAAD,CAAxB,EAAmCE,MAAA,CAAOnB,CAAP,CAAnC,EAA8CkB,IAAA,CAAKlB,CAAL,CAA9C,EAAuDV,GAAvD,CAAd;AADF;AAFQ,GAAV,KAKO;AAILQ,MAAA,GAAK,EAAL;AACA,SAAK,IAAIE,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACEF,QAAA,CAAGE,CAAH,CAAA,GAAQgB,CAAAI,KAAA,kBAAwB,CAACH,OAAD,CAAxB,EAAmCE,MAAA,CAAOnB,CAAP,CAAnC,EAA8CI,SAA9C,EAAyDd,GAAzD,CAAR;AADF;AALK;AASP,SAAOQ,EAAP;AA1B2C,CAA7C;AA4CA;;;;;;;AAAAd,IAAAG,QAAAsC,KAAA,GAAoBC,QAAQ,CAACpC,GAAD,EAAM0B,CAAN,EAASC,OAAT,CAAkB;AAC5C,MAAI,MAAO3B,IAAAmC,KAAX,IAAuB,UAAvB;AACE,WAAOnC,GAAAmC,KAAA,CAAST,CAAT,EAAYC,OAAZ,CAAP;AADF;AAGA,MAAIjC,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAON,IAAAyB,MAAAgB,KAAA,0BAAyC,CAACnC,GAAD,CAAzC,EAAgD0B,CAAhD,EAAmDC,OAAnD,CAAP;AADF;AAGA,MAAIC,OAAOlC,IAAAG,QAAAe,QAAA,CAAqBZ,GAArB,CAAX;AACA,MAAI6B,SAASnC,IAAAG,QAAAQ,UAAA,CAAuBL,GAAvB,CAAb;AACA,MAAIS,IAAIoB,MAAA1B,OAAR;AACA,OAAK,IAAIO,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACE,QAAIgB,CAAAI,KAAA,kBAAwB,CAACH,OAAD,CAAxB,EAAmCE,MAAA,CAAOnB,CAAP,CAAnC,EAA8CkB,IAA9C,IAAsDA,IAAA,CAAKlB,CAAL,CAAtD,EAA+DV,GAA/D,CAAJ;AACE,aAAO,IAAP;AADF;AADF;AAKA,SAAO,KAAP;AAf4C,CAA9C;AAkCA;;;;;;;AAAAN,IAAAG,QAAAwC,MAAA,GAAqBC,QAAQ,CAACtC,GAAD,EAAM0B,CAAN,EAASC,OAAT,CAAkB;AAC7C,MAAI,MAAO3B,IAAAqC,MAAX,IAAwB,UAAxB;AACE,WAAOrC,GAAAqC,MAAA,CAAUX,CAAV,EAAaC,OAAb,CAAP;AADF;AAGA,MAAIjC,IAAAO,YAAA,CAAiBD,GAAjB,CAAJ,IAA6BN,IAAAQ,SAAA,CAAcF,GAAd,CAA7B;AACE,WAAON,IAAAyB,MAAAkB,MAAA,0BAA0C,CAACrC,GAAD,CAA1C,EAAiD0B,CAAjD,EAAoDC,OAApD,CAAP;AADF;AAGA,MAAIC,OAAOlC,IAAAG,QAAAe,QAAA,CAAqBZ,GAArB,CAAX;AACA,MAAI6B,SAASnC,IAAAG,QAAAQ,UAAA,CAAuBL,GAAvB,CAAb;AACA,MAAIS,IAAIoB,MAAA1B,OAAR;AACA,OAAK,IAAIO,IAAI,CAAb,EAAgBA,CAAhB,GAAoBD,CAApB,EAAuBC,CAAA,EAAvB;AACE,QAAI,CAACgB,CAAAI,KAAA,kBAAwB,CAACH,OAAD,CAAxB,EAAmCE,MAAA,CAAOnB,CAAP,CAAnC,EAA8CkB,IAA9C,IAAsDA,IAAA,CAAKlB,CAAL,CAAtD,EAA+DV,GAA/D,CAAL;AACE,aAAO,KAAP;AADF;AADF;AAKA,SAAO,IAAP;AAf6C,CAA/C;;\",\n\"sources\":[\"goog/structs/structs.js\"],\n\"sourcesContent\":[\"// Copyright 2006 The Closure Library Authors. All Rights Reserved.\\n//\\n// Licensed under the Apache License, Version 2.0 (the \\\"License\\\");\\n// you may not use this file except in compliance with the License.\\n// You may obtain a copy of the License at\\n//\\n//      http://www.apache.org/licenses/LICENSE-2.0\\n//\\n// Unless required by applicable law or agreed to in writing, software\\n// distributed under the License is distributed on an \\\"AS-IS\\\" BASIS,\\n// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\\n// See the License for the specific language governing permissions and\\n// limitations under the License.\\n\\n/**\\n * @fileoverview Generics method for collection-like classes and objects.\\n *\\n * @author arv@google.com (Erik Arvidsson)\\n *\\n * This file contains functions to work with collections. It supports using\\n * Map, Set, Array and Object and other classes that implement collection-like\\n * methods.\\n * @suppress {strictMissingProperties}\\n */\\n\\n\\ngoog.provide('goog.structs');\\n\\ngoog.require('goog.array');\\ngoog.require('goog.object');\\n\\n\\n// We treat an object as a dictionary if it has getKeys or it is an object that\\n// isn't arrayLike.\\n\\n\\n/**\\n * Returns the number of values in the collection-like object.\\n * @param {Object} col The collection-like object.\\n * @return {number} The number of values in the collection-like object.\\n */\\ngoog.structs.getCount = function(col) {\\n  if (col.getCount && typeof col.getCount == 'function') {\\n    return col.getCount();\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return col.length;\\n  }\\n  return goog.object.getCount(col);\\n};\\n\\n\\n/**\\n * Returns the values of the collection-like object.\\n * @param {Object} col The collection-like object.\\n * @return {!Array<?>} The values in the collection-like object.\\n */\\ngoog.structs.getValues = function(col) {\\n  if (col.getValues && typeof col.getValues == 'function') {\\n    return col.getValues();\\n  }\\n  if (goog.isString(col)) {\\n    return col.split('');\\n  }\\n  if (goog.isArrayLike(col)) {\\n    var rv = [];\\n    var l = col.length;\\n    for (var i = 0; i < l; i++) {\\n      rv.push(col[i]);\\n    }\\n    return rv;\\n  }\\n  return goog.object.getValues(col);\\n};\\n\\n\\n/**\\n * Returns the keys of the collection. Some collections have no notion of\\n * keys/indexes and this function will return undefined in those cases.\\n * @param {Object} col The collection-like object.\\n * @return {!Array|undefined} The keys in the collection.\\n */\\ngoog.structs.getKeys = function(col) {\\n  if (col.getKeys && typeof col.getKeys == 'function') {\\n    return col.getKeys();\\n  }\\n  // if we have getValues but no getKeys we know this is a key-less collection\\n  if (col.getValues && typeof col.getValues == 'function') {\\n    return undefined;\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    var rv = [];\\n    var l = col.length;\\n    for (var i = 0; i < l; i++) {\\n      rv.push(i);\\n    }\\n    return rv;\\n  }\\n\\n  return goog.object.getKeys(col);\\n};\\n\\n\\n/**\\n * Whether the collection contains the given value. This is O(n) and uses\\n * equals (==) to test the existence.\\n * @param {Object} col The collection-like object.\\n * @param {*} val The value to check for.\\n * @return {boolean} True if the map contains the value.\\n */\\ngoog.structs.contains = function(col, val) {\\n  if (col.contains && typeof col.contains == 'function') {\\n    return col.contains(val);\\n  }\\n  if (col.containsValue && typeof col.containsValue == 'function') {\\n    return col.containsValue(val);\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return goog.array.contains(/** @type {!Array<?>} */ (col), val);\\n  }\\n  return goog.object.containsValue(col, val);\\n};\\n\\n\\n/**\\n * Whether the collection is empty.\\n * @param {Object} col The collection-like object.\\n * @return {boolean} True if empty.\\n */\\ngoog.structs.isEmpty = function(col) {\\n  if (col.isEmpty && typeof col.isEmpty == 'function') {\\n    return col.isEmpty();\\n  }\\n\\n  // We do not use goog.string.isEmptyOrWhitespace because here we treat the\\n  // string as\\n  // collection and as such even whitespace matters\\n\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return goog.array.isEmpty(/** @type {!Array<?>} */ (col));\\n  }\\n  return goog.object.isEmpty(col);\\n};\\n\\n\\n/**\\n * Removes all the elements from the collection.\\n * @param {Object} col The collection-like object.\\n */\\ngoog.structs.clear = function(col) {\\n  // NOTE(arv): This should not contain strings because strings are immutable\\n  if (col.clear && typeof col.clear == 'function') {\\n    col.clear();\\n  } else if (goog.isArrayLike(col)) {\\n    goog.array.clear(/** @type {IArrayLike<?>} */ (col));\\n  } else {\\n    goog.object.clear(col);\\n  }\\n};\\n\\n\\n/**\\n * Calls a function for each value in a collection. The function takes\\n * three arguments; the value, the key and the collection.\\n *\\n * @param {S} col The collection-like object.\\n * @param {function(this:T,?,?,S):?} f The function to call for every value.\\n *     This function takes\\n *     3 arguments (the value, the key or undefined if the collection has no\\n *     notion of keys, and the collection) and the return value is irrelevant.\\n * @param {T=} opt_obj The object to be used as the value of 'this'\\n *     within `f`.\\n * @template T,S\\n * @deprecated Use a more specific method, e.g. goog.array.forEach,\\n *     goog.object.forEach, or for-of.\\n */\\ngoog.structs.forEach = function(col, f, opt_obj) {\\n  if (col.forEach && typeof col.forEach == 'function') {\\n    col.forEach(f, opt_obj);\\n  } else if (goog.isArrayLike(col) || goog.isString(col)) {\\n    goog.array.forEach(/** @type {!Array<?>} */ (col), f, opt_obj);\\n  } else {\\n    var keys = goog.structs.getKeys(col);\\n    var values = goog.structs.getValues(col);\\n    var l = values.length;\\n    for (var i = 0; i < l; i++) {\\n      f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col);\\n    }\\n  }\\n};\\n\\n\\n/**\\n * Calls a function for every value in the collection. When a call returns true,\\n * adds the value to a new collection (Array is returned by default).\\n *\\n * @param {S} col The collection-like object.\\n * @param {function(this:T,?,?,S):boolean} f The function to call for every\\n *     value. This function takes\\n *     3 arguments (the value, the key or undefined if the collection has no\\n *     notion of keys, and the collection) and should return a Boolean. If the\\n *     return value is true the value is added to the result collection. If it\\n *     is false the value is not included.\\n * @param {T=} opt_obj The object to be used as the value of 'this'\\n *     within `f`.\\n * @return {!Object|!Array<?>} A new collection where the passed values are\\n *     present. If col is a key-less collection an array is returned.  If col\\n *     has keys and values a plain old JS object is returned.\\n * @template T,S\\n */\\ngoog.structs.filter = function(col, f, opt_obj) {\\n  if (typeof col.filter == 'function') {\\n    return col.filter(f, opt_obj);\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return goog.array.filter(/** @type {!Array<?>} */ (col), f, opt_obj);\\n  }\\n\\n  var rv;\\n  var keys = goog.structs.getKeys(col);\\n  var values = goog.structs.getValues(col);\\n  var l = values.length;\\n  if (keys) {\\n    rv = {};\\n    for (var i = 0; i < l; i++) {\\n      if (f.call(/** @type {?} */ (opt_obj), values[i], keys[i], col)) {\\n        rv[keys[i]] = values[i];\\n      }\\n    }\\n  } else {\\n    // We should not use goog.array.filter here since we want to make sure that\\n    // the index is undefined as well as make sure that col is passed to the\\n    // function.\\n    rv = [];\\n    for (var i = 0; i < l; i++) {\\n      if (f.call(opt_obj, values[i], undefined, col)) {\\n        rv.push(values[i]);\\n      }\\n    }\\n  }\\n  return rv;\\n};\\n\\n\\n/**\\n * Calls a function for every value in the collection and adds the result into a\\n * new collection (defaults to creating a new Array).\\n *\\n * @param {S} col The collection-like object.\\n * @param {function(this:T,?,?,S):V} f The function to call for every value.\\n *     This function takes 3 arguments (the value, the key or undefined if the\\n *     collection has no notion of keys, and the collection) and should return\\n *     something. The result will be used as the value in the new collection.\\n * @param {T=} opt_obj  The object to be used as the value of 'this'\\n *     within `f`.\\n * @return {!Object<V>|!Array<V>} A new collection with the new values.  If\\n *     col is a key-less collection an array is returned.  If col has keys and\\n *     values a plain old JS object is returned.\\n * @template T,S,V\\n */\\ngoog.structs.map = function(col, f, opt_obj) {\\n  if (typeof col.map == 'function') {\\n    return col.map(f, opt_obj);\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return goog.array.map(/** @type {!Array<?>} */ (col), f, opt_obj);\\n  }\\n\\n  var rv;\\n  var keys = goog.structs.getKeys(col);\\n  var values = goog.structs.getValues(col);\\n  var l = values.length;\\n  if (keys) {\\n    rv = {};\\n    for (var i = 0; i < l; i++) {\\n      rv[keys[i]] = f.call(/** @type {?} */ (opt_obj), values[i], keys[i], col);\\n    }\\n  } else {\\n    // We should not use goog.array.map here since we want to make sure that\\n    // the index is undefined as well as make sure that col is passed to the\\n    // function.\\n    rv = [];\\n    for (var i = 0; i < l; i++) {\\n      rv[i] = f.call(/** @type {?} */ (opt_obj), values[i], undefined, col);\\n    }\\n  }\\n  return rv;\\n};\\n\\n\\n/**\\n * Calls f for each value in a collection. If any call returns true this returns\\n * true (without checking the rest). If all returns false this returns false.\\n *\\n * @param {S} col The collection-like object.\\n * @param {function(this:T,?,?,S):boolean} f The function to call for every\\n *     value. This function takes 3 arguments (the value, the key or undefined\\n *     if the collection has no notion of keys, and the collection) and should\\n *     return a boolean.\\n * @param {T=} opt_obj  The object to be used as the value of 'this'\\n *     within `f`.\\n * @return {boolean} True if any value passes the test.\\n * @template T,S\\n */\\ngoog.structs.some = function(col, f, opt_obj) {\\n  if (typeof col.some == 'function') {\\n    return col.some(f, opt_obj);\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return goog.array.some(/** @type {!Array<?>} */ (col), f, opt_obj);\\n  }\\n  var keys = goog.structs.getKeys(col);\\n  var values = goog.structs.getValues(col);\\n  var l = values.length;\\n  for (var i = 0; i < l; i++) {\\n    if (f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col)) {\\n      return true;\\n    }\\n  }\\n  return false;\\n};\\n\\n\\n/**\\n * Calls f for each value in a collection. If all calls return true this return\\n * true this returns true. If any returns false this returns false at this point\\n *  and does not continue to check the remaining values.\\n *\\n * @param {S} col The collection-like object.\\n * @param {function(this:T,?,?,S):boolean} f The function to call for every\\n *     value. This function takes 3 arguments (the value, the key or\\n *     undefined if the collection has no notion of keys, and the collection)\\n *     and should return a boolean.\\n * @param {T=} opt_obj  The object to be used as the value of 'this'\\n *     within `f`.\\n * @return {boolean} True if all key-value pairs pass the test.\\n * @template T,S\\n */\\ngoog.structs.every = function(col, f, opt_obj) {\\n  if (typeof col.every == 'function') {\\n    return col.every(f, opt_obj);\\n  }\\n  if (goog.isArrayLike(col) || goog.isString(col)) {\\n    return goog.array.every(/** @type {!Array<?>} */ (col), f, opt_obj);\\n  }\\n  var keys = goog.structs.getKeys(col);\\n  var values = goog.structs.getValues(col);\\n  var l = values.length;\\n  for (var i = 0; i < l; i++) {\\n    if (!f.call(/** @type {?} */ (opt_obj), values[i], keys && keys[i], col)) {\\n      return false;\\n    }\\n  }\\n  return true;\\n};\\n\"],\n\"names\":[\"goog\",\"provide\",\"require\",\"structs\",\"getCount\",\"goog.structs.getCount\",\"col\",\"isArrayLike\",\"isString\",\"length\",\"object\",\"getValues\",\"goog.structs.getValues\",\"split\",\"rv\",\"l\",\"i\",\"push\",\"getKeys\",\"goog.structs.getKeys\",\"undefined\",\"contains\",\"goog.structs.contains\",\"val\",\"containsValue\",\"array\",\"isEmpty\",\"goog.structs.isEmpty\",\"clear\",\"goog.structs.clear\",\"forEach\",\"goog.structs.forEach\",\"f\",\"opt_obj\",\"keys\",\"values\",\"call\",\"filter\",\"goog.structs.filter\",\"map\",\"goog.structs.map\",\"some\",\"goog.structs.some\",\"every\",\"goog.structs.every\"]\n}\n"]